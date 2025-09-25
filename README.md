# タスク管理アプリ

Java/JSPを使って、ログイン機能とタスクのCRUD操作（作成・読み込み・削除）を学習するために制作したアプリケーションです。

---

## 🚀 アプリの機能と現在の状況

### 実装済み機能

* **ログイン機能**: データベース（MySQL）に登録されたアカウントでのログイン認証。
* **タスク登録 (Create)**: タスクの新規作成機能の実装（ただし、現在は処理完了後にログイン画面に戻る暫定的な状態）。
* **タスク削除 (Delete)**: （機能の**骨組み**のみ実装済み。DAO/Logicへの連携は未着手）
* **タスク完了チェック**: **JSP上での見た目**のみ実装済み（チェックを入れてもDBに状態は保存されません）。

### 現在のステータス

本リポジトリは、タスク管理機能の**コアロジック実装中**の途中段階です。

| 機能 | 状況 | 詳細 |
| :--- | :--- | :--- |
| **ログイン** | **完了** | DB接続・認証ロジックは実装済み。 |
| **タスク追加 (Create)** | **実装中** | 登録処理後、正しい画面遷移（タスク一覧）への修正が必要です。 |
| **タスク一覧 (Read)** | **未着手** | DBからタスクを取得・表示するロジックは未実装。 |
| **タスク削除 (Delete)** | **未着手** | サーブレットからの削除呼び出しロジックは未実装。 |
| **タスク完了 (Update)** | **未着手** | データベースの更新ロジックは未実装。 |

### 今後の展望

1.  タスク登録後の**正しい画面（タスク一覧）への遷移**を実装し、機能を完成させる。
2.  タスク一覧の**DB連携（Read）**、および**削除（Delete）**機能を完成させる。
3.  タスク完了ステータスをDBに保存する**更新（Update）**機能を実装する。
4.  パスワードの**ハッシュ化**など、セキュリティ強化を行う。

---

## 🛠️ 技術スタック

* **言語**: Java 2025
* **Webフレームワーク**: Servlet/JSP
* **データベース**: MySQL
* **Webサーバー**: Apache Tomcat
* **環境**: Eclipse (macOS / Intel Core i5)

---

## 💡 動作確認手順

### 1. データベース設定

MySQLで以下のSQLを実行し、データベースとテーブルを作成してください。

```sql
-- データベース作成
CREATE DATABASE task_app_db;

-- usersテーブル作成
CREATE TABLE task_app_db.users (
  user_id INT PRIMARY KEY AUTO_INCREMENT,
  user_name VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(50) NOT NULL
);

-- tasksテーブル作成
CREATE TABLE task_app_db.tasks (
  task_id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  tasks VARCHAR(50) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- テストアカウントの挿入
INSERT INTO task_app_db.users (user_name, password) VALUES ('testuser', 'password123');
