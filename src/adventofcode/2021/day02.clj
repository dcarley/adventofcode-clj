(ns adventofcode.2021.day02
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def start-position
  {:horizontal 0
   :depth 0
   :aim 0})

(defn parse-line
  [line]
  (let [[direction units] (str/split line #" ")]
    {:direction direction
     :units (Integer/parseInt units)}))

(defn parse
  [input]
  (->> input
       io/reader
       line-seq
       (map parse-line)))

(defn apply-instruction
  [position instruction]
  (prn instruction)
  (let [{:keys [direction units]} instruction]
    (condp = direction
      "forward" (update position :horizontal #(+ % units))
      "down" (update position :depth #(+ % units))
      "up" (update position :depth #(- % units)))))

(defn apply-instruction-with-aim
  [position instruction]
  (let [{:keys [direction units]} instruction]
    (condp = direction
      "forward" (-> position
                    (update :horizontal #(+ % units))
                    (update :depth #(+ % (* units (:aim position)))))
      "down" (update position :aim #(+ % units))
      "up" (update position :aim #(- % units)))))

(defn solve
  [fn input]
  (let [position (reduce fn start-position (parse input))]
    (* (:horizontal position) (:depth position))))

(defn part1
  [input]
  (solve apply-instruction input))

(defn part2
  [input]
  (solve apply-instruction-with-aim input))
