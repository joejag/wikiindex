(ns wikiindex.plumbing.logger)

(defn indexing-file []
  (println " * Indexing file"))

(defn creating-lucene-index []
  (println " * Creating Lucene index"))

(defn starting-http-server []
  (println " * Starting http server"))

(defn count-loaded [index]
  (println (str " * Loaded " (count index) " records")))