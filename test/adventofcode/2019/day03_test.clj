(ns adventofcode.2019.day03-test
  (:require [clojure.test :refer :all]
            [adventofcode.2019.day03 :as day03]))

(def example1
  (char-array "R8,U5,L5,D3
U7,R6,D4,L4"))

(def example2
  (char-array "R75,D30,R83,U83,L12,D49,R71,U7,L72
U62,R66,U55,R34,D71,R55,D58,R83"))

(def example3
  (char-array "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51
U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"))

(deftest day03
  (testing "move-once"
    (is (= [0 1] (day03/move-once "U" [0 0])))
    (is (= [0 -1] (day03/move-once "D" [0 0])))
    (is (= [-1 0] (day03/move-once "L" [0 0])))
    (is (= [1 0] (day03/move-once "R" [0 0]))))

  (testing "move-line"
    (is (= '([0 -2] [0 -1] [0 0] [0 1] [0 2])
           (day03/move-line "U5" [0 -3]))))

  (testing "move-wire"
    (is (= '([0 1] [0 2]
             [1 2] [2 2]
             [2 1] [2 0] [2 -1] [2 -2]
             [1 -2] [0 -2])
           (day03/move-wire ["U2" "R2" "D4" "L2"]))))

  (testing "manhattan-distance"
    (is (= 6 (day03/manhattan-distance [0 0] [3 3])))
    (is (= 4 (day03/manhattan-distance [1 1] [-1 -1]))))

  (testing "part1 examples"
    (is (= 6 (day03/nearest-intersection example1)))
    (is (= 159 (day03/nearest-intersection example2)))
    (is (= 135 (day03/nearest-intersection example3))))

  (testing "part1 solution"
    (is (= 1626 (day03/part1)))))
