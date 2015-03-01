(ns wikiindex.data-provider
  (:require [clojure.java.io :as io]))

(def ^:private cached-wikimedia-dump
  (io/input-stream (io/resource "enwiki-latest-abstract23.xml")))

(defn read-from-local-cache []
  cached-wikimedia-dump)