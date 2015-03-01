(ns wikiindex.util)

(defn in?
  "true if seq contains elem"
  [seq elem]
  (some #(= elem %) seq))
