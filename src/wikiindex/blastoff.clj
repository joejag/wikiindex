(ns wikiindex.blastoff
  (:require [bidi.ring :as bidi]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.params :as params]
            [wikiindex.routes :as routes]))

(def app (-> routes/routes
             (bidi/make-handler)
             params/wrap-params))

(defn -main [& _]
  ; download file from http://localhost:5000/public/enwiki-latest-abstract23.xml
  (jetty/run-jetty app {:port 5000 :join? false}))