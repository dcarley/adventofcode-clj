(ns adventofcode.2020.day04
  (:require [clojure.string :as string]
            [clojure.set :as set]))

(def required-fields
  {"byr" #(let [x (Integer/parseInt %)] (<= 1920 x 2002))
   "iyr" #(let [x (Integer/parseInt %)] (<= 2010 x 2020))
   "eyr" #(let [x (Integer/parseInt %)] (<= 2020 x 2030))
   "hgt" #(cond
            (string/ends-with? % "cm")
            (let [x (Integer/parseInt (string/replace % "cm" ""))]
              (<= 150 x 193))
            (string/ends-with? % "in")
            (let [x (Integer/parseInt (string/replace % "in" ""))]
              (<= 59 x 76)))
   "hcl" #(some? (re-find #"^#[0-9a-f]{6,6}" %))
   "ecl" #(contains? #{"amb" "blu" "brn" "gry" "grn" "hzl" "oth"} %)
   "pid" #(some? (re-find #"^[0-9]{9,9}" %))})

(defn parse-line
  [line]
  (apply hash-map (-> line
                      (string/replace #"\n" " ")
                      (string/split #"[ :]"))))

(defn parse
  [input]
  (map parse-line
       (string/split (slurp input) #"\n\n")))

(defn valid-part1?
  [passport]
  (empty? (set/difference (set (keys required-fields))
                          (set (keys passport)))))

(defn valid-part2?
  [passport]
  (try 
    (every? true? (for [[k pred] required-fields]
                    (pred (get passport k))))
    (catch Exception _ false)))

(defn solve
  [valid? input]
  (->> input
       parse
       (filter #(valid? %))
       count))
