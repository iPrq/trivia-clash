import React from 'react';
import { Routes, Route, Link } from 'react-router-dom';
import Landing from './pages/Landing';
import Auth from './pages/Auth';
import Lobby from './pages/Lobby';
import Game from './pages/Game';

export default function App() {
  return (
    <div className="min-h-screen bg-gray-50 text-gray-900">
      <nav className="bg-white border-b">
        <div className="max-w-5xl mx-auto px-4 py-3 flex items-center justify-between">
          <Link to="/" className="text-xl font-extrabold tracking-tight">
            Trivia Clash
          </Link>
          <div className="space-x-3">
            <Link to="/lobby" className="px-3 py-1.5 rounded bg-indigo-600 text-white">
              Play
            </Link>
            <Link to="/auth" className="px-3 py-1.5 rounded border">
              Login
            </Link>
          </div>
        </div>
      </nav>

      <main className="max-w-5xl mx-auto p-4">
        <Routes>
          <Route path="/" element={<Landing />} />
          <Route path="/auth" element={<Auth />} />
          <Route path="/lobby" element={<Lobby />} />
          <Route path="/game/:roomId" element={<Game />} />
        </Routes>
      </main>
    </div>
  );
}
