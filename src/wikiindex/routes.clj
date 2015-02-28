(ns wikiindex.routes
  (:require [bidi.ring :as bidi]
            [cheshire.core :as json]
            [wikiindex.search :refer [search]]))

(defn serve-index [_]
  {:status 200
   :body   "Welcome to WikiIndex!"})

(defn serve-search [_]
  (let [search-result (search nil nil)]
    {:status       200
     :content-type "application/json"
     :body         (json/generate-string search-result)}))

(def routes ["/" {""       {:get serve-index}
                  "search" {:get serve-search}
                  "static" (bidi/->ResourcesMaybe {:prefix "static/"})}])

