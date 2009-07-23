(ns euler.problem-6)
(defn square-sum-sum-square ([seq]
  (let [square #(* % %)]
    (- (square (reduce + seq)) (reduce + (map square seq))))))
(println (time (square-sum-sum-square '(1 2 3))))
(println (time (square-sum-sum-square (range 101))))
