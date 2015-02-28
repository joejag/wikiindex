(defproject wikiindex "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring "1.3.2"]
                 [bidi "1.18.7"]]
  :main wikiindex.core
  :aot [wikiindex.core]
  :plugins [[lein-midje "3.1.3"]]
  :profiles {:dev {:dependencies [[midje "1.6.3"]]}})