import { NextResponse } from 'next/server';
import fs from 'fs';
import path from 'path';

export async function POST(request: Request) {
  try {
    const data = await request.json();

    
    const dirPath = path.join(process.cwd(), 'data', 'submissions');

    
    if (!fs.existsSync(dirPath)) {
      fs.mkdirSync(dirPath, { recursive: true });
    }

   
    const filename = `submission-${Date.now()}.json`;
    const filePath = path.join(dirPath, filename);

   
    fs.writeFileSync(filePath, JSON.stringify(data, null, 2), 'utf-8');

    return NextResponse.json({ success: true, filename });
  } catch (error) {
    console.error('File write error:', error);
    return NextResponse.json({ success: false, error: 'Failed to save submission' }, { status: 500 });
  }
}