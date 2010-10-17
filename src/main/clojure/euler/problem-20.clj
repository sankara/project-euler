(ns euler.problem-20)
(def atoi #(Character/digit % 10))

(defn fact! [n] (reduce * (range 1 (+ n 1))))
(time (println (reduce + (map atoi (str (fact! 100))))))

;648
;"Elapsed time: 26.671207 msecs"
