import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],

  server: {
    open: true, // 서버 구동시 웹브라우저 자동활성화
    port: 3000, // port 번호를 3000 번으로 수정
  },
  
})