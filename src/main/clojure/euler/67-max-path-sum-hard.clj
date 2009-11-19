(ns euler.67-max-path-sum-hard
    (:use clojure.contrib.duck-streams)
    (:use clojure.contrib.str-utils)
    (:use euler.18-max-path-sum))

(defn to-num [a]
    (Integer/parseInt a))

(defn to-vec []
    (vec (map vec
        (map #(map to-num (re-split #" " %))
            (read-lines "triangle.txt")))))

(println (time (max-path-sum (to-vec))))
;"Elapsed time: 860.877985 msecs"
;7273
