(ns wikiindex.core.routing
  (:require [cheshire.core :as json]
            [ring.middleware.params :as params]
            [bidi.ring :as bidi]
            [wikiindex.core.search :refer [search]]))

(defn homepage-handler [_]
  {:headers {"content-type" "text/html"}
   :body    "<h2>Welcome to Wiki Index!</h2>Check out <a href='/search?q=title'>our search</a>"})

(defn serve-search [request index]
  (let [search-query (get-in request [:query-params "q"])
        search-results (search search-query index)]
    {:headers {"content-type" "application/json"}
     :body    (json/generate-string search-results)}))

(defn routes [search-handler]
  ["/" {""       {:get homepage-handler}
        "search" {:get search-handler}}])

(defn app [index]
  (let [search-handler (fn [request] (serve-search request index))]
    (-> (routes search-handler)
        bidi/make-handler
        params/wrap-params)))