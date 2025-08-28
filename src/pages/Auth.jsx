import React from 'react';

export default function Auth() {
  return (
    <div className="max-w-md mx-auto mt-12 bg-white p-6 rounded-xl shadow">
      <h2 className="text-2xl font-bold mb-4">Login</h2>
      <button className="w-full px-4 py-2 rounded border">Sign in with Google (coming soon)</button>
      <p className="text-sm text-gray-500 mt-3">
        We’ll hook this to your friend’s backend (or Firebase) later.
      </p>
    </div>
  );
}

