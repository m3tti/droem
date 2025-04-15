(ns App
  (:require
   ["react" :refer [useState]]
   ["react-native" :refer [Text View StyleSheet StatusBar Button]]))

(def initialState {:route "home"})

(def styles (StyleSheet.create
             {:container {:flex 1
                          :backgroundColor "#2d2d2d"
                          :alignItems "center"
                          :justifyContent "center"}}))

(defn- TestView [{:keys [state setState]}]
  #jsx [View {:style styles.container}
        [Text {:style {:color "#ffffff"}} "Hello"]
        [Button {:onPress #(setState {:route "home"}) :title "Home"}]
        [StatusBar {:style "auto"}]])

(defn- HomeView [{:keys [state setState]}]
  #jsx [View {:style styles.container}
        [Text {:style {:color "#ffffff"}} "Droem 2.0"]
        [Button {:onPress #(setState {:route "test"}) :title "Test"}]
        [StatusBar {:style "auto"}]])

(defn- App []
  (let [[state setState] (useState initialState)]
    (case (:route state)
      "home" #jsx [HomeView {:state state :setState setState}]
      "test" #jsx [TestView {:state state :setState setState}])))

(def default App)
