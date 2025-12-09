import type { Config } from "tailwindcss";

export default {
    content: [
        "./pages/**/*.{js,ts,jsx,tsx,mdx}",
        "./components/**/*.{js,ts,jsx,tsx,mdx}",
        "./app/**/*.{js,ts,jsx,tsx,mdx}",
    ],
    theme: {
        extend: {
            colors: {
                solana: {
                    purple: '#9945FF',
                    green: '#14F195',
                },
            },
            fontFamily: {
                sans: ['var(--font-outfit)', 'sans-serif'],
            },
        },
    },
    plugins: [],
} satisfies Config;
