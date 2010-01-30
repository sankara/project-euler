(ns euler.39
    (:use clojure.contrib.math))

(defn frequency-table [& seqs]
    (let [count-fn
          (fn [s item]
              (update-in s [item] #(if % (inc %) 1)))]
        (reduce #(reduce count-fn %1 %2) {} seqs)))

(defn perm-perimeters [p]
    (for [a (range 1 (/ p 2)) b (range 1 (/ p 2))]
        (let [c (sqrt (+ (* a a) (* b b)))]
            (if (= c (int c))
                (+ a b c)))))

(defn vec-max
    ([v1 v2] (if (> (last v1) (last v2)) v1 v2)))

(defn main [p]
    (reduce vec-max
        (filter #(and (not (nil? (first %))) (<= (first %) 1000))
            (frequency-table (perm-perimeters 1000)))))

(println (time (main 1000)))

;"Elapsed time: 1632.922031 msecs"
;[840 16]
