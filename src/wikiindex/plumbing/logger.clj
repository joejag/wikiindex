(ns wikiindex.plumbing.logger)

(defn indexing-file []
  (println " * Indexing file"))

(defn starting-http-server []
  (println " * Starting http server"))

(defn count-loaded [index]
  (println (str " * Loaded " (count index) " records")))