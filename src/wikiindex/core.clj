(ns wikiindex.core)

(def app
  (fn [_] {:status 200 :body "Hello World!"}))

(defn -main [& args]
  (println "Make it so"))