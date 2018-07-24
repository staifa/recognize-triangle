(ns recognize-triangle.schemas
  (:require 
    [clojure.edn :as edn]
    [struct.core :as st]))


(defonce ^{:private true} coll-edn-like
  {:message "must be valid EDN"
   :validate #(every? true? (map (fn [item] 
                                   (try 
                                     (edn/read-string item)
                                     true 
                                     (catch Exception e 
                                       false))) %))
   :optional true
   :coerce #(map edn/read-string %)})


(defonce ^{:private true} coll-float-like
  {:message "must be valid number"
   :validate #(every? true? (map (fn [item] 
                                   (try 
                                     (float item)
                                     true 
                                     (catch Exception e 
                                       false))) %))
   :optional true
   :coerce #(map float %)})


(def SideLengthsSchema
  {:side-lengths [st/required st/coll [st/min-count 3] coll-edn-like [st/every number?] coll-float-like]})


