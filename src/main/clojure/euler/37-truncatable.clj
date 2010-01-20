(ns euler.37
    (:use clojure.contrib.lazy-seqs))

(def primes-as-set (set (sort (take-while #(< % 1000000) primes))))

(defn to-int [str-n]
    (Integer/parseInt (apply str str-n)))

(defn truncatable? [n next-n]
    (loop [str-n (str n)]
        (if (empty? str-n) true
            (if (not (contains? primes-as-set (to-int str-n))) false
                (recur (next-n str-n))))))

(defn truncatable-left? [n]
    (truncatable? n #(rest %)))

(defn truncatable-right? [n]
    (truncatable? n #(reverse (rest (reverse %)))))

(defn truncatable-lr? [n]
    (and (truncatable-left? n)
        (truncatable-right? n)))

(defn main []
    (sort (take 15 (filter truncatable-lr? primes-as-set))))

(println (time (main)))

;"Elapsed time: 615.493905 msecs"
;(2 3 5 7 23 37 53 73 313 317 373 797 3137 3797 739397)

;user=> (reduce + '(23 37 53 73 313 317 373 797 3137 3797 739397))
;748317
