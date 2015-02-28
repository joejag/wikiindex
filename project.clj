(defproject wikiindex "0.1.0"
            :dependencies [[org.clojure/clojure "1.6.0"]
                           [ring "1.3.2"]
                           [bidi "1.18.7"]
                           [cheshire "5.4.0"]]
            :main wikiindex.blastoff
            :aot [wikiindex.blastoff]
            :ring {:handler wikiindex.blastoff/app :port 5000}
            :plugins [[lein-midje "3.1.3"]
                      [lein-ring "0.8.11"]]
            :profiles {:dev {:dependencies [[midje "1.6.3"]]}})
