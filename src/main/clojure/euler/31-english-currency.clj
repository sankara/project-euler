(ns euler.31)

(defn count-coins [amount coins]
    (if (= 1 (count coins))
        1
        (let [coin (first coins) max-num (int (/ amount coin))]
            (reduce + (for [i (range 0 (inc max-num))]
                (count-coins (- amount (* i coin)) (rest coins)))))))

(defn main []
    (count-coins 200 (reverse '(1 2 5 10 20 50 100 200))))

(println (time (main)))

;"Elapsed time: 185.231576 msecs"
;73682
