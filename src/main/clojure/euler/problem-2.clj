(ns euler.problem-2)
(def fibs (lazy-cat [1 2] (map + fibs (rest fibs)))) 
(defn sum-even-upto ([limit] (apply + (take-while #(< % limit) (filter even? fibs)))))
(println (time (sum-even-upto 4000000)))
