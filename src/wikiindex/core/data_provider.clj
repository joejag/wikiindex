(ns wikiindex.core.data-provider
  (:require [clojure.java.io :as io]))

(def ^:private cached-wikimedia-dump "enwiki-latest-abstract23.xml")
(def ^:private fake-data "test-docs.xml")

(defn resource->stream [place]
  (io/input-stream (io/resource place)))

(defn load-wikimedia []
  (resource->stream cached-wikimedia-dump))

(defn load-fake []
  (resource->stream fake-data))