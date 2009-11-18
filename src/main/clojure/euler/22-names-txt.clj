(ns euler.22-names-txt
    (:use clojure.contrib.duck-streams)
    (:use clojure.contrib.str-utils))

(defn sum-pos [s]
    (reduce + (map #(inc (- (int %) (int \A))) (str s))))

(def sorted-names
    (sort (map #(re-gsub #"[^A-Z]" "" %)
        (re-split #"," (first (read-lines "names.txt"))))))

(def pos-val
    (for [i (range 0 (count sorted-names))] (* (inc i) (sum-pos (nth sorted-names i)))))

(println (time (reduce + pos-val)))
;"Elapsed time: 931.389045 msecs"
;871198282
