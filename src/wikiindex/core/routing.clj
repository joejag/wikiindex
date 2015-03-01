(ns wikiindex.core.routing
  (:require [cheshire.core :as json]
            [ring.middleware.params :as params]
            [bidi.ring :as bidi]
            [wikiindex.core.search :refer [search]]))

(defn homepage-handler [_]
  {:body "Welcome to Wiki Index!"})

(defn serve-search [request index]
  (let [search-query (get-in request [:query-params "q"])
        search-results (search search-query index)]
    {:content-type "application/json"
     :body         (json/generate-string search-results)}))

(defn routes [search-handler]
  ["/" {""       {:get homepage-handler}
        "search" {:get search-handler}}])

(defn app [index]
  (let [search-handler (fn [request] (serve-search request index))]
    (-> (routes search-handler)
        bidi/make-handler
        params/wrap-params)))