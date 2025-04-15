(ns App
  (:require
   [DreamDiary :as dd]
   ["react" :refer [useState]]
   ["react-native" :refer [Text View StyleSheet StatusBar Button]]))

(def initialState {:route :dd-index})

(def styles (StyleSheet.create
             {:container {:flex 1
                          :backgroundColor "#2d2d2d"
                          :alignItems "center"
                          :justifyContent "center"}}))

(defn- with-state [stateProps component]
  (component stateProps))

(defn- App []
  (let [[state setState] (useState initialState)]
    (with-state {:state state :setState setState}
      (case (:route state)
        :dd-index dd/Index
        :dd-edit dd/Edit
        ddv/Index))))

(def default App)
