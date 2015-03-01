(ns wikiindex.plumbing.config
  (:require [environ.core :refer [env]]))

(defn port []
  (Integer. (or (env :port) 5000)))

(defn search-results-limit []
  (Integer. (or (env :search-results-limit) 20)))
