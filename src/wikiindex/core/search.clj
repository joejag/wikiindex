(ns wikiindex.core.search
  (:require [clojure.string :as str]
            [wikiindex.plumbing.config :as config]
            [wikiindex.plumbing.functions :refer [in?]]))

(defn- contains-term? [term sentence]
  (let [words (str/split sentence #" ")]
    (in? words term)))

(defn- matches? [term {title :title abstract :abstract}]
  (or (contains-term? term title)
      (contains-term? term abstract)))

(defn search-for [search-term index]
  (take (config/search-results-limit)
        (filter (fn [doc] (matches? search-term doc)) index)))

(defn search [search-term index]
  (let [results (search-for search-term index)]
    {:q       search-term
     :results results}))
