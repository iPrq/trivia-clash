import React from 'react';
import { Link } from 'react-router-dom';

export default function Landing() {
  return (
    <section className="text-center py-20">
      <h1 className="text-5xl font-extrabold mb-3">Trivia Clash</h1>
      <p className="text-gray-600 mb-8">Fast, real-time multiplayer quizzes. Join a room and battle your friends!</p>

      <div className="flex gap-4 justify-center">
        <Link to="/auth" className="px-6 py-3 rounded bg-indigo-600 text-white">Get Started</Link>
        <Link to="/lobby" className="px-6 py-3 rounded border">Jump to Lobby</Link>
      </div>

      <p className="text-xs text-gray-400 mt-8">Phase 2 UI prototype — backend wiring comes later.</p>
    </section>
  );
}
