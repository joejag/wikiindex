(ns wikiindex.search
  (:require [clojure.string :as str]))

(defn- contains-term? [term setenance]
      (some (fn [word] (= term word)) (str/split setenance #" ")))

(defn- matches? [term {title :title abstract :abstract}]
  (or (contains-term? term title)
      (contains-term? term abstract)))

(defn search-for [search-term index]
  (filter (fn [candidate] (matches? search-term candidate)) index))

(defn search [search-term _]
  (let [results []]
    {:q       search-term
     :results results}))
