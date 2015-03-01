(ns wikiindex.blastoff
  (:require [ring.adapter.jetty :as jetty]
            [wikiindex.data-provider :as data-provider]
            [wikiindex.routing :as routing]
            [wikiindex.indexer :as indexer]
            [wikiindex.logger :as log]))

(defn blastoff []
  (let [db (data-provider/read-from-local-cache)
        index (indexer/parse db)]
    (log/count-loaded index)))

(defn -main [& _]
  (blastoff)
  (log/starting-http-server)
  (jetty/run-jetty routing/app {:port 5000 :join? false}))



