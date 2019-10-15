(ns notebook)
(require '[clojure.string :as str])

(defrecord Note [body tags date-created time-created location])

(defn get-month [my-month]
    (def months {"01" "January" "02" "February" "03" "March" "04" "April" "05" "May" "06" "June" 
                 "07" "July" "08" "August" "09" "September" "10" "October" "11" "November" "12" "December"})
        (months my-month))

(def date-now (get (str/split (str (java.time.LocalDateTime/now)) #"T") 0))

(def time-of-day (get (str/split (str (java.time.LocalDateTime/now)) #"T") 1))

(def time-now (get (str/split time-of-day #"\.") 0))  ; remove milliseconds

(defn build-note [body-text tags location]
    (->Note body-text tags (str date-now) (str time-now) location))

(def my-note (build-note "Today cool things happened..." ["dagbog" "oktober"] "Lejligheden, DK"))

