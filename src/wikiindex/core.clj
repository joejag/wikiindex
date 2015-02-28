(ns wikiindex.core
  (:require [bidi.ring :as bidi]
            [ring.adapter.jetty :as jetty]))

(def serve-index
  (fn [_] {:status 200 :body "Welcome to WikiIndex!"}))

(def serve-search
  (fn [_] {:status 200 :body "Hello from search, nothing to see here just now"}))

(def routes ["/" {""       {:get serve-index}
                  "search" {:get serve-search}}])

(def app (-> routes
             (bidi/make-handler)))

(defn -main [& _]
  (jetty/run-jetty app {:port 5000 :join? false}))