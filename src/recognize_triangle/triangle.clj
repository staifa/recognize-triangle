(ns recognize-triangle.triangle
  (:require
    [struct.core :as st]
    [tol.core :refer [if-let*]]
    [recognize-triangle.schemas :refer [SideLengthsSchema]]))


(defn recognize
  [args]
  (if-let* [side-lengths-args (take 3 args)
            [errors side-lengths] (st/validate {:side-lengths side-lengths-args} SideLengthsSchema)
            _ (nil? errors)
            a (first (:side-lengths side-lengths))
            b (second (:side-lengths side-lengths))
            c (nth (:side-lengths side-lengths) 2)
            _ (and (> (+ a b) c) (> (+ a c) b) (> (+ b c) a))
            different-sides-count (count (into #{} (:side-lengths side-lengths)))]
           (str "The triangle is " (case different-sides-count
                                     1 "Equilateral"
                                     2 "Isosceles"
                                     3 "Scalene"))
           "You must pass 3 numerical values that are valid triangle side lengths as input parameters"))
