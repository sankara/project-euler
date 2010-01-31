(ns euler.56
    (:use clojure.contrib.math))

(def atoi #(Character/digit % 10))

(defn main [n]
    (reduce max
        (for [i (range 1 n) j (range 1 n)]
            (reduce + (map atoi (str (expt i j)))))))

(println (time (main 100)))

;"Elapsed time: 19883.497825 msecs"
;972
