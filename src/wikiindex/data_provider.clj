(ns wikiindex.data-provider
  (:require [clojure.xml :as xml]
            [clojure.java.io :as io]
            [wikiindex.logger :as log]))

(def ^:private cached-wikimedia-dump
  (io/file (io/resource "enwiki-latest-abstract23.xml")))

(defn read-from [place]
  (log/reading-file-to-xml)
  (xml/parse place))

(defn read-from-local-cache []
  (read-from cached-wikimedia-dump))