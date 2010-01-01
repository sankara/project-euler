(ns euler.26
    (:use clojure.contrib.math))

(defn discrete-log
    "b^k = r (mod n)"
    [n b r]
    (loop [k 1]
        (if (= r (mod (expt b k) n))
            k
            (recur (inc k)))))

(defn main [n]
    (reduce
        #(if (> (discrete-log %1 10 1) (discrete-log %2 10 1)) %1 %2)
        (filter #(= (gcd % 10) 1) (range 2 (inc n)))))

(println (time (main 1000)))

;"Elapsed time: 5597.625146 msecs"
;983
;Math solution based on this http://eli.thegreenplace.net/2009/02/25/project-euler-problem-26/
