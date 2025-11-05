# 🌅 DailyQuoteApp

> 一個使用 **Kotlin + Jetpack Compose + Retrofit** 製作的「每日金句 App」，  
> 每次開啟或點擊按鈕，會從 [Quotable API](https://api.quotable.io/random) 取得隨機名言。

---

## ✨ 功能特色

- 顯示隨機名言與作者  
-  點擊「再來一句」即可重新取得金句  
-  漸層背景 + 淡入動畫呈現  
-  使用 **Jetpack Compose** 打造現代化 UI  
-  使用 **Retrofit + Coroutine** 進行網路請求  

---

## 🧠 技術架構

| 類別 | 說明 |
|:--|:--|
| `MainActivity.kt` | App 入口，載入 Compose UI |
| `DailyQuoteApp()` | 主要畫面（含漸層背景與按鈕） |
| `QuoteViewModel.kt` | 管理 UI 狀態（isLoading / quote / error） |
| `QuoteRepository.kt` | 從 API 取得資料 |
| `RetrofitInstance.kt` | Retrofit 與 OkHttp 客戶端設定 |
| `QuoteApiService.kt` | 定義 API 介面 |
| `Quote.kt` | 名言資料模型 |

---

## 💡 使用的主要套件

- [Jetpack Compose](https://developer.android.com/jetpack/compose) — 現代 UI 工具包  
- [Retrofit2](https://square.github.io/retrofit/) — 網路請求  
- [Gson Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/gson) — JSON 解析  
- [OkHttp3](https://square.github.io/okhttp/) — HTTP 客戶端  
- [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) — 非同步執行  

---

## 🖼️ 畫面預覽


![quoteEveryday](https://github.com/user-attachments/assets/246ea121-3cff-492d-a76e-6f462cb86940)


---

## ⚙️ 如何執行

1. Clone 專案
- 在終端機輸入以下指令：
- git clone https://github.com/Yneq/DailyQuoteApp.git

2. 使用 Android Studio 開啟專案

3. 確保你的環境

- Android Studio：Koala / Iguana 或更新版
- JDK：17 以上
- 已安裝 Compose 與 Kotlin 插件

4. 執行 App
- 點選 ▶️ Run 即可在模擬器或真機上運行

---

🧭 API 來源
- 使用免費的 Quotable API
- 每次呼叫 /random 端點即可取得一則隨機名言，例如：

{
"_id": "KkXZvEJzF",
"content": "The best way to get started is to quit talking and begin doing.",
"author": "Walt Disney"
}

---

🧑‍💻 作者
- Vance Weng
- 📍 Taiwan
- 📬 https://github.com/Yneq

---

📄 License
- 本專案僅作為學習與展示用途。
- Quotes API 內容來源：https://api.quotable.io

