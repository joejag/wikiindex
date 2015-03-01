(ns wikiindex.routes
  (:require [bidi.ring :as bidi]
            [cheshire.core :as json]
            [wikiindex.search :refer [search]]))

(defn serve-index [_]
  {:body "Welcome to WikiIndex!"})

(defn serve-search [request]
  (let [serach-query (get-in request [:query-params "q"])
        search-results (search serach-query [])]
    {:content-type "application/json"
     :body         (json/generate-string search-results)}))

(def routes ["/" {""       {:get serve-index}
                  "search" {:get serve-search}
                  "static" (bidi/->ResourcesMaybe {:prefix "static/"})}])

