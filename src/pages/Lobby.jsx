import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function Lobby() {
  const [roomIdInput, setRoomIdInput] = useState('');
  const navigate = useNavigate();

  const createRoom = () => {
    // temporary: fake room id
    const roomId = Math.random().toString(36).slice(2, 8);
    navigate(`/game/${roomId}`);
  };

  const joinRoom = (e) => {
    e.preventDefault();
    if (!roomIdInput.trim()) return;
    navigate(`/game/${roomIdInput.trim()}`);
  };

  return (
    <div className="max-w-2xl mx-auto mt-10 bg-white p-6 rounded-xl shadow">
      <h2 className="text-2xl font-bold mb-4">Lobby</h2>

      <div className="flex gap-3 mb-6">
        <button onClick={createRoom} className="px-4 py-2 rounded bg-indigo-600 text-white">
          Create Room
        </button>
        <form onSubmit={joinRoom} className="flex gap-2">
          <input
            className="border rounded px-3 py-2"
            placeholder="Enter Room ID"
            value={roomIdInput}
            onChange={(e) => setRoomIdInput(e.target.value)}
          />
          <button className="px-4 py-2 rounded border">Join</button>
        </form>
      </div>

      <div className="text-sm text-gray-600">
        (Later: this will list active rooms in real time)
      </div>
    </div>
  );
}
