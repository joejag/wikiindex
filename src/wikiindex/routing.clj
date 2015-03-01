(ns wikiindex.routing
  (:require [cheshire.core :as json]
            [wikiindex.search :refer [search]]
            [ring.middleware.params :as params]
            [bidi.ring :as bidi]))

(defn serve-index [_]
  {:body "Welcome to Wiki Index!"})

(defn serve-search [request]
  (let [serach-query (get-in request [:query-params "q"])
        search-results (search serach-query [])]
    {:content-type "application/json"
     :body         (json/generate-string search-results)}))

(def routes ["/" {""       {:get serve-index}
                  "search" {:get serve-search}}])

(def app (-> routes
             (bidi/make-handler)
             params/wrap-params))