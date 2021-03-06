(ns wikiindex.blastoff
  (:require [ring.adapter.jetty :as jetty]
            [wikiindex.core.data-provider :as data-provider]
            [wikiindex.core.routing :as routing]
            [wikiindex.core.indexer :as indexer]
            [wikiindex.plumbing.logger :as log]
            [wikiindex.plumbing.config :as config]))

(defn blastoff [db]
  (let [index (indexer/parse db)]
    (log/count-loaded index)
    (routing/app index)))

(defn blastoff-testing [request]
  (let [handler (blastoff (data-provider/load-fake))]
    (handler request)))

(defn -main []
  (let [handler (blastoff (data-provider/load-wikimedia))]
    (log/starting-http-server)
    (jetty/run-jetty handler {:port (config/port) :join? false})))



