(ns recognize-triangle.triangle-test
  (:require [clojure.test :refer :all]
            [recognize-triangle.triangle :refer [recognize]]))


(defonce ^{:private true} equilateral-reponse 
  "The triangle is Equilateral")
(defonce ^{:private true} isosceles-response 
  "The triangle is Isosceles")
(defonce ^{:private true} scalene-response 
  "The triangle is Scalene")
(defonce ^{:private true} fail-response 
  "You must pass 3 numerical values that are valid triangle side lengths as input parameters")


(deftest recognize-triangle-test
  (testing "should return Equilateral response, int values"
    (let [response (recognize ["1" "1" "1"])] 
      (is (= response equilateral-reponse))))

  (testing "should return Isosceles response, int values"
    (let [response (recognize ["1" "2" "2"])] 
      (is (= response isosceles-response))))

  (testing "should return Isosceles response, int values, different order"
    (let [response (recognize ["2" "1" "2"])] 
      (is (= response isosceles-response))))

  (testing "should return Scalene response, int values"
    (let [response (recognize ["1" "2" "2.5"])] 
      (is (= response scalene-response))))

  (testing "should return Scalene response, int values, different order"
    (let [response (recognize ["2.5" "1" "2"])] 
      (is (= response scalene-response))))

  (testing "should return Equilateral response, float values"
    (let [response (recognize ["1.2" "1.2" "1.2"])] 
      (is (= response equilateral-reponse))))

  (testing "should return Isosceles response, float values"
    (let [response (recognize ["1.2" "2.2" "2.2"])] 
      (is (= response isosceles-response))))

  (testing "should return Scalene response, float values"
    (let [response (recognize ["1.2" "2.2" "3.2"])] 
      (is (= response scalene-response))))

  (testing "should return Equilateral response, mixed values"
    (let [response (recognize ["1.0" "1" "1.0"])] 
      (is (= response equilateral-reponse))))

  (testing "should return Scalene response, more args"
    (let [response (recognize ["1.0" "2" "2.5" "2.5"])] 
      (is (= response scalene-response))))

  (testing "should return Isosceles response, more non-numeric args"
    (let [response (recognize ["1.0" "1" "1.9" "asd"])] 
      (is (= response isosceles-response))))

  (testing "should return fail response, nil args"
    (let [response (recognize nil)] 
      (is (= response fail-response))))

  (testing "should return fail response, 1 arg"
    (let [response (recognize ["1.0"])] 
      (is (= response fail-response))))

  (testing "should return fail response, 2 args"
    (let [response (recognize ["1.0" "1"])] 
      (is (= response fail-response))))

  (testing "should return fail response, wrong side lengths"
    (let [response (recognize ["1.0" "1" "2"])] 
      (is (= response fail-response))))

  (testing "should return fail response, wrong side lengths"
    (let [response (recognize ["2" "1.0" "1"])] 
      (is (= response fail-response))))

  (testing "should return fail response, wrong side lengths"
    (let [response (recognize ["1" "2" "1.0"])] 
      (is (= response fail-response))))

  (testing "should return fail response, string arg"
    (let [response (recognize ["1.0" "1" "a"])] 
      (is (= response fail-response))))

  (testing "should return fail response, map arg"
    (let [response (recognize ["1.0" "1" "{:a 1}"])] 
      (is (= response fail-response))))

  (testing "should return fail response, vector arg"
    (let [response (recognize ["1.0" "1" "[1 2 2]"])] 
      (is (= response fail-response)))))
