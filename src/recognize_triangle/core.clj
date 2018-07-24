(ns recognize-triangle.core
  (:require
    [recognize-triangle.triangle :as triangle]))


(defn -main
  [& args]
  (println (triangle/recognize args)))
