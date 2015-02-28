(ns wikiindex.search)

(defn search-for [request index]
  (filter (constantly true) index))

(defn search [request _]
  (let [results []]
    {:q       request
     :results results}))
