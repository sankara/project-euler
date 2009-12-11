(ns euler.23)
(defn sum-proper [n]
    (let [sn (int (. Math sqrt n))]
        (reduce #(+ %1 %2 (if (= %2 (/ n %2)) 0 (/ n %2))) (filter #(zero? (mod n %)) (range 1 (inc sn))))))

(defn abundants [n]
    (set (filter #(> (sum-proper %) %) (range 1 (inc n)))))

(defn sum-of-abundants? [abundants-seq n]
    (some #(contains? abundants-seq (- n %)) abundants-seq))

(defn main [n]
    (let [ab-seq (abundants n)]
        (reduce + (filter
            (complement (partial sum-of-abundants? ab-seq))
            (range 1 (inc n))))))

(println (time (main 28123)))

;"Elapsed time: 9703.12786 msecs"
;4179871
