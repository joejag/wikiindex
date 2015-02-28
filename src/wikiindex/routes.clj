(ns wikiindex.routes
  (:require [bidi.ring :as bidi]
            [cheshire.core :as json]
            [wikiindex.search :refer [search]]))

(defn serve-index [_]
  {:body "Welcome to WikiIndex!"})

(defn serve-search [request]
  (let [serach-query (get-in request [:query-params "q"])
        search-result (search serach-query nil)]
    {:content-type "application/json"
     :body         (json/generate-string search-result)}))

(def routes ["/" {""       {:get serve-index}
                  "search" {:get serve-search}
                  "static" (bidi/->ResourcesMaybe {:prefix "static/"})}])

