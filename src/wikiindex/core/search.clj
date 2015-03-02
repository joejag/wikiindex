(ns wikiindex.core.search
  (:require [clojure.string :as str]
            [wikiindex.plumbing.config :as config]
            [wikiindex.plumbing.functions :refer [in?]]))

(defn- contains-term? [search-term sentence]
  (let [words (str/split sentence #" ")]
    (in? words search-term)))

(defn- matches? [search-term {title :title abstract :abstract}]
  (or (contains-term? search-term title)
      (contains-term? search-term abstract)))

(defn search-for [search-term index]
  (take (config/search-results-limit)
        (filter (fn [doc] (matches? search-term doc)) index)))

(defn search [search-term index]
  (let [results (search-for search-term index)]
    {:q       search-term
     :results results}))
