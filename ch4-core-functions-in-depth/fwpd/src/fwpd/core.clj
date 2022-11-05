(ns fwpd.core
  (:gen-class))

(def filename "suspects.csv")

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(def vamp-keys [:name :glitter-index])

(defn str->int [str] (Integer. str))

(def conversions {:name identity :glitter-index str->int})

(defn convert [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert a CSV into rows and columns."
  [string]
  (map #(clojure.string/split % #",") (clojure.string/split string #"\n")))

(defn mapify
  "Return a seq of map liek {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

;; This is my implementation
(defn mapify
  "Return a seq of map liek {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (into [](map
   (fn [[name glitter-index]]
     {:name name :glitter-index (str->int glitter-index)})
   rows)))

(defn mapify
  "Return a seq of map liek {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map
   (fn [[name glitter-index]]
     {:name name :glitter-index (str->int glitter-index)})
   rows))

(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))

;; exercise 1
;; Turn the result of glitter-filter into a list of name
(defn glitter-filter->list-of-names
  [minimum-glitter records]
  (map :name (glitter-filter minimum-glitter records)))

;; Exercise 2
;; append a suspect to my _list_ of suspects
(def append conj)

;; Exercise 3
;; Validate a suspect entyr (must have name and glitter-index)
;; Don't use :pre and :post form
(defn valid? [{:keys [name glitter-index]}]
  (and name glitter-index true))

;; Exercise 4
;; Turn the records back to csv format.
(defn suspect->csv [records]
  (clojure.string/join "\n"
                       (map
                        (fn [{:keys [name glitter-index]}]
                          (str name "," glitter-index))
                            records)))
